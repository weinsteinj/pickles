<template>
<div>
<!-- <div class="pet-spotlight-container"> -->
      <div class="flexslider carousel" >
          <ul class="slides">
            <li v-for="img_link in photos"  v-bind:key="img_link" ><img class="img" v-bind:src="img_link" /></li>
            <!-- <li>
              <img class="img-left" src="https://res.cloudinary.com/picklepoints/image/upload/v1660750512/xxc1pbb8avuzbxw3n0os.jpg" />
            </li> -->
            <!-- <li>
              <img class="img-center" src="../assets/images/nicholasdog.jpg" />
            </li>
            <li>
              <img class="img-right" src="../assets/images/stockcuteturtle.jpg" />
            </li>
            <li>
              <img class="img-left" src="../assets/images/caitosdog.jpg" />
            </li>
            <li>
              <img class="img-center" src="../assets/images/nicholasdog.jpg" />
            </li>
            <li>
              <img class="img-right" src="../assets/images/stockcuteturtle.jpg" />
            </li>
            <li>
              <img class="img-left" src="../assets/images/caitosdog.jpg" />
            </li>
            <li>
              <img class="img-center" src="../assets/images/nicholasdog.jpg" />
            </li>
            <li>
              <img class="img-right" src="../assets/images/stockcuteturtle.jpg" />
            </li>
            <li>
              <img class="img-left" src="../assets/images/caitosdog.jpg" />
            </li>
            <li>
              <img class="img-center" src="../assets/images/nicholasdog.jpg" />
            </li>
            <li>
              <img class="img-right" src="../assets/images/stockcuteturtle.jpg" />
            </li>
             -->
        </ul> 
    </div>
  <!-- </div>    -->
</div>
  


      <!-- <router-link :to="{/* TODO - Links to Registration */}" >Join us (tbd)</router-link> -->

</template>

<script>
import photoService from "@/services/photoService.js";
const $ = window.$;
//const cloudinary = window.cloudinary;

export default {
    name: 'pet-spotlight',
    data () {
      return {
        photos: []
      }
      
    },
    created() {
      photoService.getAllPhotos()
      .then((response) => {
        if (response.status === 200) {
          this.photos = response.data;
          console.log(this.photos);
        }
      })
    },

    mounted() {
      // const myGallery = cloudinary.galleryWidget({ 
      //   container: "#pet-spotlight-container", 
      //   cloudName: "picklepoints", 
      //   mediaAssets: [{ tag: "pet" }] 
      // });
      // myGallery.render();
      let recaptchaScript = document.createElement('script')
      recaptchaScript.setAttribute('src', 'https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js')
      document.head.appendChild(recaptchaScript)

    $(window).load(function() {
    $('.flexslider').flexslider({
    animation: "slide",
    animationLoop: true,
    itemWidth: 10,
    itemMargin: 0,
    minItems: 6,
    maxItems: 6,
    slideshow: true,                //Boolean: Animate slider automatically
    slideshowSpeed: 7000,           //Integer: Set the speed of the slideshow cycling, in milliseconds
    animationSpeed: 600,   
    randomize: true

  });
});
  }
}
</script>

<style scoped>



.pet-spotlight-container {
    margin-top: 5rem;
    display: flex;
    background-color: #184E77;
    justify-content: space-around;
    border-radius: 15px 15px 15px 15px;
    box-shadow: 0px 5px 5px rgba(0, 0, 0, 0.18);
    margin: 5rem 1rem 0 1rem;
    height: 15rem;
  
}

.flex-control-paging li a {
  text-indent: 0px;
  display: none;
}

.pet-spotlight-container:hover {
  box-shadow: 0 10px 10px rgba(0, 0, 0, 0.18);
  
}



.slides {
  padding-top: 15px;
   padding-bottom: 15px;
  background: var(--secondary-green);
  
}

.slides img:hover {
  box-shadow: 10px 10px 10px 10px rgba(0, 0, 0, 0.18);
  
  
}

 img {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 100%;
  object-fit: cover;
  justify-content: center;
  align-items: center;
  padding-top: 5px;
  padding-bottom: 5px;
  padding-left: 10px;
  padding-right: 10px;
     height: 230px;
    width: 280px;
    border-radius: 30px 30px 30px 30px;
}

.flexslider {
  background: none; 
  margin: 0px;
  border: none;
  
}

body {
  padding-top: 0rem;
  margin-top: 0;
}

 /* {
  margin-right: ;
} */
</style>