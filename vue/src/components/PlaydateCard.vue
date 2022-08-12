<template>
    <body>
        <h2> {{playdate.hostId}}{{playdate.zipcode}}</h2>
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