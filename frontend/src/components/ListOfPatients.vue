<template>
<div>
    <h2> List of Current Patients</h2>
       
    

 <ul>
        <li
        v-bind:key="p.id"
        v-for="p in ListPatients">
        <input class="button" type="submit"  @click="this.viewPatient(p.id)" value="Detailed view" />
        {{p.fullName}}
        </li>
      

    </ul>
    

</div>
</template>


<script>
   export default {
    name: 'listOfPatients',
    props: ['ListPatients'],
    component : { },

   methods : {
    viewPatient(number) {
        console.log("view :",number )
        this.getUserdata(number)
        
    },
    async getUserdata(userid) {
    
      var link =this.$backend.geturlGetUserInfoAsDoctor(userid)
      this.loginerror=true
      

      await this.axios.get(
        link        
      ).then(

        res => {
          this.$backend.user = res.data
          console.log("user: ", this.$backend.user )
          this.$router.Meta({showDoctorback : true})
          this.$router.push('/pages/UserWelcomePage' )

        }
      ) .catch(function (error) {
    if (error.response) {
      this.loginerror=true
     }
      }
      )
    },
   }
   }
</script>