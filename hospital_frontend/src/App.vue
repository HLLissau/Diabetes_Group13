<template>
  <div>
      <h1>Hospial management</h1>

      <h3>Functions</h3>
      <ol>
        <li><router-link :to="{ name: 'ListHospital' }">List of hospitals</router-link></li>
        <li><router-link :to="{ name: 'AddHospital' }">Add new hospital</router-link></li>
      </ol>

      <router-view
        :hospitals="this.hospitals"
        @new-hospital="refresh"
        @hospital-deleted="refresh" />
  </div>
  <div>
    <b-button>Button</b-button>
    <b-button variant="danger">Button</b-button>
    <b-button variant="success">Button</b-button>
    <b-button variant="outline-primary">Button</b-button>
  </div>
</template>

<script>
import router from './router.js'
export default {
  name: 'App',
  components: { },
  data() {
    return {
      hospitals: []
    }
  },
  methods: {
    refresh() {
      this.axios
        .get(this.$backend.getUrlHospitalList())
        .then(res => {
          this.hospitals = res.data
          router.push({ name: 'ListHospital' })
        })
    }
  },
  mounted() {
    this.refresh()
  }
}
</script>

<style>
* {
  font-family: sans-serif;
}
</style>