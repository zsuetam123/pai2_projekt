<template>
  <div class="log">

    <form @submit.prevent="formSubmit">
      <p>
        <label>Email:</label>
        <input id="email" type="text" class="form-control" v-model="email" placeholder="email" required>
      </p>

      <p>
        <label>Hasło:</label>
        <input id="haslo" type="text" class="form-control" v-model="haslo" placeholder="hasło" required>
      </p>

      <p>
        <input type="submit" value="Zaloguj">
      </p>
    </form>
  <br>
    <form @submit.prevent>
      <p>
        <label>Jeśli nie masz konta, zarejestruj się.</label>
      </p>

      <p>
        <input type="submit" value="Zarejestruj" @click="swapView(3)">
      </p>
    </form>

  </div>
</template>

<script>

  export default {
    data() {
      return {
        email: '',
        haslo: '',
        id: '',
        a:'Złe haslo'
      }
    },

    methods: {
      swapView(text) {
    this.$emit('changeView', text);
  },
      passId(id){
        this.$emit('passId', id);
      },

      formSubmit() {
        this.axios.post('http://localhost:8080/login',  null, { params: {
            email: this.email,
            haslo: this.haslo
          }}).then(response =>{
          this.id = response.data;
          console.log(this.id);
          console.log(response);

          if((this.a.localeCompare(this.id[3]))===0)
          {
            this.haslo = '';
            this.$alert("Błędne hasło");
          }
          else
            {
              switch (this.id[7]){
                case "user":
                  this.passId(this.id);
                  this.swapView(2);
                  break;
                case "admin":
                  this.passId(this.id);
                  this.swapView(4);
                  break;
                default:
                  this.$alert("Brak uprawnien");
              }
            }
        }).catch(error => {
          console.log(error);
          this.$alert("Brak konta o podanym adresie email");
        })
      },

    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h3 {
    margin: 40px 0 0;
  }
  ul {
    list-style-type: none;
    padding: 0;
  }
  li {
    display: inline-block;
    margin: 0 10px;
  }
  a {
    color: #42b983;
  }
  .log{
    background: #efefef;
    width: 20%;
    margin: auto;
    padding: 10px;
    border-radius: 10px;
    box-shadow: 0 0 10px 1px #6d6d6d;
  }
</style>
