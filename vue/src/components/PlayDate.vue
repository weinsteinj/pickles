<template>
  <div>
    <div class="pet-card" v-for="pet in $store.state.petArray" v-bind:key="pet.id"> 
      {{pet.name}}
      </div>

  </div>
</template>

<script>

export default {
  components: {
    
  },
  data () {
    return {
    
    }
  }
}
</script>

<style>

</style>