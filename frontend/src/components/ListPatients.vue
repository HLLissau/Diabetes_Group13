<template>

  <div>
    <h2>List of patients of hospital {{hospitalId}} </h2>
    <ul>
       <li
        v-bind:key="h.name"
        v-for="h in hospitalPatients">
        {{ h.name }}
        </li>
    </ul>
 

    <form v-on:submit.prevent="submitForm">
        <label>
          Name: <input type="text" v-model="form.name" />
        </label>
        <button>Submit</button>
    </form>
  </div>

</template>

<script>
export default {
  name: 'ListPatients',
  props: ['patients','hospitals'],
  data(){
    return {
      form: {
        name: ""
      },
      hospitalId: null,
      hospitalPatients: []
    }
  },
  mounted() {
  this.hospitalId = this.$route.params.id
  this.hospitalPatients = this.$route.params.patients
  },
  methods: {
    submitForm() {
      this.axios.post(this.$backend.getUrlPostPatient(this.hospitalId), this.form)
        .then(() => {
          this.form.name = ""
          //this.$emit('new-patient')
        })
    }
  }
}
</script>


