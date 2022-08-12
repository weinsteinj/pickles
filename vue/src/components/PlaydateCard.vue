<template>
    <body>
        <h2> Host User ID: {{playdate.hostUserId}}  
            <br>
        ZipCode of Playdate: {{playdate.zipCode}}</h2>
    </body>
</template>

<script>
export default {
    name: 'playdate-card',
    props: {
        playdate: Object,
    },
}
</script>

<style>

</style>