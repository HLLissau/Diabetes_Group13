<template>
  <div>
    <h2>List of hospitals</h2>
    <ul>
       <li
        v-bind:key="h.id"
        v-for="h in hospitals">
        <button @click="deleteHospital(h.id)">Delete</button> -
        {{ h.name }} -
        <router-link :to="{ name: 'ListPatients', params: { id: h.id } }">Patients list</router-link>
        </li>
    </ul>
  </div>
</template>


<script>
export default {
  name: 'ListHospital',
  props: ['hospitals'],
  methods: {
    deleteHospital(id) {
      this.axios
        .delete(this.$backend.getUrlDeleteHospital(id))
        .then(() => {
          this.$emit('hospital-deleted')
        })
    }
  }
}
</script>