<template>
    <form role="form">
        <div class="form-group">
            <label for="username">Username:</label> <input type="text"
                                                           class="form-control" id="username" name="username"
                                                           v-model="credentials.username"/>
        </div>
        <div class="form-group">
            <label for="password">Password:</label> <input type="password"
                                                           class="form-control" id="password" name="password"
                                                           v-model="credentials.password"/>
        </div>
        <button class="btn btn-primary" v-on:click="login()">Submit</button>
    </form>
</template>

<script>
export default {
    name: "Login",

    data() {
        return {
            credentials: {username: '', password: ''}
        }
    },

    methods: {
        login() {
            this.$store.dispatch('authentication/authenticate', this.credentials)
                .then(() => this.$router.push('/'));
        }
    }
}
</script>

<style scoped>

</style>