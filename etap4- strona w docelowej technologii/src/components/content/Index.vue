<template>
    <div style="box-shadow: 0 5px 10px 0 black;">
    <div id="index">
            <article>
                <b>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</b>Praesent ultricies rutrum dui at tristique. Cras eget velit libero.
                Ut nisl massa, malesuada eu accumsan nec, rutrum vel turpis. Proin sit amet ligula vitae sapien elementum pharetra sed quis felis.
                Quisque et nisi magna. Nunc at lacinia libero, et luctus leo. Fusce varius neque eu purus fermentum, non elementum ipsum sollicitudin.
                Nullam id eleifend velit. Integer eget mollis risus.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ultricies rutrum dui at tristique. Cras eget velit libero.
                Ut nisl massa, malesuada eu accumsan nec, rutrum vel turpis. Proin sit amet ligula vitae sapien elementum pharetra sed quis felis.
                Quisque et nisi magna. Nunc at lacinia libero, et luctus leo. Fusce varius neque eu purus fermentum, non elementum ipsum sollicitudin.
                Nullam id eleifend velit. Integer eget mollis risus.
            </article>
            <div class="photo" style="text-align: left">
                <img :src="image" width="430px"/>
            </div>
            <div style="clear: both; height: 50px"></div>
            <div class="photo" style="text-align: right">
                <img :src="image2" width="308px"/>
            </div>
            <article>
                <b>Tutaj będą wyniki wyborów</b> Praesent ultricies rutrum dui at tristique. Cras eget velit libero.
                Ut nisl massa, malesuada eu accumsan nec, rutrum vel turpis. Proin sit amet ligula vitae sapien elementum pharetra sed quis felis.
                Quisque et nisi magna. Nunc at lacinia libero, et luctus leo. Fusce varius neque eu purus fermentum, non elementum ipsum sollicitudin.
                Nullam id eleifend velit. Integer eget mollis risus.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ultricies rutrum dui at tristique. Cras eget velit libero.
                Ut nisl massa, malesuada eu accumsan nec, rutrum vel turpis. Proin sit amet ligula vitae sapien elementum pharetra sed quis felis.
                Quisque et nisi magna. Nunc at lacinia libero, et luctus leo. Fusce varius neque eu purus fermentum, non elementum ipsum sollicitudin.
                Nullam id eleifend velit. Integer eget mollis risus.
            </article>
            <div style="clear: both; height: 50px"></div>
        </div>
        <div id="getVote">
            <div id="vote" class="mybutton" @click="changeMenu()" >Głosowanie</div>
        </div>
    </div>
</template>

<script>
    import image from "./polish-flag.jpg";
    import image2 from "./emblem.jpg";


    export default {
        data: function () {
            return {
                image: image,
                image2: image2,
            }
        },
        methods:{
          changeMenu() {
              let val = 5;
              this.$emit('menuValue', val);
          }
        },
    }
</script>

<style scoped>
    article{
        margin-bottom: 15px;
        float:left;
        width: 48%;
    }
    .photo{
        float:left;
        margin-left: 10px;
        margin-right: 10px;
        width:48%;
    }
    #index{
        padding-top: 30px;
        text-align: left;
        width:70%;
        margin: auto;
    }
    img{
        height: 300px;
        border-radius: 5%;
    }
    #getVote{
        width:100%;
        padding-top: 30px;
        text-align: center;
        background: #3d3d3d;
        border: 1px black;
        box-shadow:  0 -2px 5px 0 black;
        height: 80px;
    }
    #vote{
        margin: auto;
        padding: 10px;
        background: #e60000;
        color: #f7f7f7;
        cursor: pointer;
        max-width: 100px;
        border-radius: 3px;
    }
    #vote:hover{
        background: #f7f7f7;
        color: #e60000;
    }
    #vote:active{
        position: relative;
        top: 2px;
    }
</style>