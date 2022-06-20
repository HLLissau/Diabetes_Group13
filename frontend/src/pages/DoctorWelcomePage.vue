<template>
   <div class="welcome-wrap">
      <h1> Welcome {{this.$backend.doctor.fullName}}  </h1> 

     
    <ListOfPatients :ListPatients="this.patients" />
    <AddPatient/>
   
    </div>
</template>

<script>
import ListOfPatients from "../components/ListOfPatients.vue";
import AddPatient from "../components/AddPatient.vue";
import axios from "axios";
export default {
 components: { AddPatient,ListOfPatients },
 data() {
  return{
    patients: []
  }
 },
 methods : {
  refresh()  {
    axios
      .get(this.$backend.geturlPatientList())
        .then(res => {
          console.log("patientlist:",res.data)
          this.patients = res.data
        })
  }

 }, 
  mounted() {
    this.refresh()
  }

}

</script>

<style>
/* .links .routerlink {
  color:orange;
  background-color: yellow;
  text-decoration: none;

  border-bottom: 3px solid transparent;
  border-top: 3px solid transparent;
  padding: 10px 20px;

} */
/*
div#chart {
  justify-content: flex-start;
  float: left;
  width: 30vw;
  padding-top: 15px;

}
div#current {
  position: absolute;
  padding-left: 120px;
  top: 15vh;
}

div#welcome {
    width: 10vw;
    height: 50vh;
    position:absolute;
    top:15vh;
  }

header {
  background-color: #222;
  padding: 15px;
}
*/
</style>
