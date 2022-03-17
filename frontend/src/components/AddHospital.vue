<template>
  <div>
    <h2>Add new hospital</h2>
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
  name: 'AddHospital',
  data() {
    return {
      form: {
        name: ""
      }
    }
  },
  
  methods: {
    submitForm() {
      this.axios.post(this.$backend.getUrlPostHospital(), this.form)
        .then(() => {
          this.form.name = ""
          this.$emit('new-hospital')
        })
    }
  }
}
</script>
