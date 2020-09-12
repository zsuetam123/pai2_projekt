<template>
    <div>
        <label>Informacje o wyborcach śledzących kandydata</label>
        <li v-for="(item, index) in FavCandidateInfo" :key="`item-${index}`">
         {{index+1}}.  Miejscowość: {{FavCandidateInfo[index].locality}}, Adres email: {{FavCandidateInfo[index].adressEmail}}
        </li>
    </div>
</template>

<script>
    export default {

        props: [
            'FavCandidateInfo',],

        data() {
            return {
                name: "ElectionStaffFollow"
            }
        },

    }
</script>

<style scoped>

</style>