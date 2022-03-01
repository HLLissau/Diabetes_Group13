<template>
  <div>
    <h2>Add new patient</h2>
    <form v-on:submit.prevent="submitForm">
        <label>
          Name: <input type="text" v-model="form.name" />
        </label>
        <button>Sumit</button>
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
          console.log("hospital added")
          this.$emit('new-hospital')
        })
    }
  }
}
</script>
