<template>
  <div>
    <div>
      <h2>Search and add a pin</h2>
    </div>
    <br>
    <google-maps
      :center='center'
      :zoom='12'
      style='width:100%;  height: 400px;'
    />
  </div>
</template>

<script>
export default {
  name: 'gm',
  data() {
    return {
      center: { lat: 45.508, lng: -73.587 },
    }
  },
};
</script>