<template>
  <div>
    <h2>New user</h2>
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
  components: {  },
  name: 'AddPatient',
  data() {
    return {
      form: {
        name: ""
      }
    }
  },
  
  methods: {
    submitForm() {
      this.axios.post(this.$backend.getUrlAddUserToDoctor(), this.form)
        .then(() => {
          this.form.name = ""
          this.$emit('new-patient')
        })
    }
  }
}
</script>
