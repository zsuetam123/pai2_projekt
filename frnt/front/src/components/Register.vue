<template>
    <div class="Regis">

        <form @submit.prevent="formSubmit">
            <p>
                <label>Imię:</label>
                <input id="Imie" type="text" class="form-control" v-model="Imie" placeholder="Imię" required>
            </p>

            <p>
                <label>Nazwisko:</label>
                <input id="Nazwisko" type="text" class="form-control" v-model="Nazwisko" placeholder="Nazwisko" required>
            </p>

            <p>
                <label>Pesel:</label>
                <input id="Pesel" type="text" class="form-control" v-model="Pesel" placeholder="Pesel" required>
            </p>

            <p>
                <label>Miejscowość:</label>
                <input id="Miejscowosc" type="text" class="form-control" v-model="Miejscowosc" placeholder="Miejscowość" required>
            </p>

            <p>
                <label>Email:</label>
                <input id="Email" type="text" class="form-control" v-model="Email" placeholder="Email" required>
            </p>

            <p>
                <label>Login:</label>
                <input id="Login" type="text" class="form-control" v-model="Login" placeholder="Login" required>
            </p>

            <p>
                <label>Hasło:</label>
                <input id="Haslo" type="text" class="form-control" v-model="Haslo" placeholder="Hasło" required>
            </p>

            <p>
                <input type="submit" value="Zarejestruj">
            </p>

        </form>

            <form @submit.prevent>
            <p>
                <input type="button" value="Powrót do logowania" @click="swapView(1)">
            </p>

        </form>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                Imie: '',
                Nazwisko: '',
                Pesel: '',
                Miejscowosc: '',
                Email: '',
                Login: '',
                Haslo: '',
                status:'',
                a:'Pesel, login lub email zajęty'
            }
        },

        methods: {
            swapView(text) {
                this.$emit('changeView', text);
            },

            formSubmit() {
                this.axios.post('http://localhost:8080/regis',  null, { params: {
                        Imie: this.Imie,
                        Nazwisko: this.Nazwisko,
                        Pesel: this.Pesel,
                        Miejscowosc: this.Miejscowosc,
                        Email: this.Email,
                        Login: this.Login,
                        Haslo: this.Haslo
                    }}).then(response =>{

                    this.status = response.data;
                    if((this.a.localeCompare(this.status))===0)
                    {
                        this.Email = ''
                        this.Pesel = ''
                        this.Login = ''
                        this.$alert("Pesel, login lub email zajęty");
                    }else
                    {
                        this.swapView(1);
                    }
                    console.log(response);

                }).catch(error => {
                    console.log(error);
                })
            }
    }
    }
</script>

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
</style>