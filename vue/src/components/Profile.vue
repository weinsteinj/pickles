<template>
  <div>
      <h1>{{user.firstName}}'s Profile</h1>
  </div>
</template>

<script>
import userService from '@/services/userService.js';
export default {
    name: 'profile-component',

    data() {
        return {
            user: {}
        }
    },

    created() {
        userService.getById(this.$route.params.userId).then((response) => {
            this.user = response.data;
        })
    }

}
</script>

<style>

</style>