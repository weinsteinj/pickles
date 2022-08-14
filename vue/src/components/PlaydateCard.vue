<template>
    <body>
        <h2> Host User ID: {{playdate.hostUserId}}  
            <br>
        ZipCode of Playdate: {{playdate.zipCode}}</h2>
        <br>
        <div>
            Pets: 
            {{pets.join(', ')}}
        </div>
            </body>
</template>

<script>
export default {
    name: 'playdate-card',
    data() {
        return {
            pets: []
        }
    },
    props: {
        playdate: Object,
    },
    created() {
        const unique = (value, index, self) => {
        return self.indexOf(value) === index
    }
    
        let allPetsArray = this.$store.state.petArray;
        let playdatePets = this.playdate.petId;
        
        for(let i=0; i<allPetsArray.length; i++) {
            
            playdatePets.forEach((element) => {
                
                allPetsArray.forEach(pet => {
                    let petIdHere = pet.petId;
               
                    if (element === petIdHere)
                    this.pets.push(pet.name)
                    
                     })
                })
            this.pets(unique);  
        }
            
        
    },

    methods: {
        getNamesFromId(id){
            this.$store.state.petArray.find(element => {
                element.id === id;
            })
        }
    }
}
</script>

<style>

</style>