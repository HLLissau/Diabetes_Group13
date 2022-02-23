<template>
  <div>
      <h2>List of patients at hospital with id {{ hospitalId }}</h2>
      <ul>
          <li>Here goes the list of patients for the given hospital...</li>
      </ul>
  </div>
</template>

<script>
export default {
  name: 'ListPatients',
  data() {
    return {
      hospitalId: null
    }
  },
  mounted() {
    this.hospitalId = this.$route.params.id
  }
}
</script>