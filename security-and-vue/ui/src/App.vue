<template>
  <div id="app">
    <div id="nav">
        <router-link to="/">Home</router-link>
        |
        <router-link to="/login">Login</router-link>
        |
        <a v-on:click="logout()">Logout</a>
    </div>
    <router-view/>
  </div>
</template>

<script>
export default {
    methods: {
        logout() {
            this.$store.dispatch('authentication/logout')
                .finally(() => {
                    this.$router.push('login');
                })
        }
    }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

</style>
