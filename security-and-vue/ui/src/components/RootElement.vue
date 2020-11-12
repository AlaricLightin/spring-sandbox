<template>
    <div>
        <p>Id: <span>{{greeting.id}}</span></p>
        <p>Message: <span>{{greeting.content}}!</span></p>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: "RootElement",

    data() {
        return {
            greeting: {'id': 'XXX', 'content': 'Hello World'}
        }
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