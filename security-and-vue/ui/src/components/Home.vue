<template>
    <div>
        <h1>Greeting</h1>
        <div v-if="authenticated">
            <p>Id: <span>{{greeting.id}}</span></p>
            <p>Message: <span>{{greeting.content}}!</span></p>
        </div>
        <div v-else>
            <p>Login to see your greeting</p>
        </div>
    </div>
</template>

<script>
import axios from 'axios'
import {mapState} from "vuex";

export default {
    name: "Home",

    data() {
        return {
            greeting: {'id': 'XXX', 'content': 'Hello World'}
        }
    },

    computed: {
        ...mapState({
            authenticated: state => state.authentication.authenticated
        })
    },

    created() {
        axios
            .get("/resource")
            .then(r => {
                this.greeting = r.data
            })
    }
}
</script>

<style scoped>

</style>