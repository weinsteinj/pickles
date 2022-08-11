<template>
  <div>
    <div class="pet-card" v-for="pet in $store.state.petArray" v-bind:key="pet.id"> 
      {{`Click here to learn more about ${pet.name}`}}. {{ pet.sex == 'Male' ? 'He' : 'She' }} is a {{pet.species.toLowerCase()}}.
      </div>
  </div>
</template>

<script>

export default {
  name: "play",
  components: {
  },
  data () {
    return {
    
    }
  },
}
</script>

<style>

</style>