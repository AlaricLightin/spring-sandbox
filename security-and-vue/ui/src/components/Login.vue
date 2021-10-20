<template>
    <div>
        <div>
            <label for="username">Username:</label> <input type="text"
                                                           id="username" name="username"
                                                           v-model="credentials.username"/>
        </div>
        <div>
            <label for="password">Password:</label> <input type="password"
                                                           id="password" name="password"
                                                           v-model="credentials.password"/>
        </div>
        <button class="btn btn-primary" v-on:click="login()">Submit</button>
    </div>
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