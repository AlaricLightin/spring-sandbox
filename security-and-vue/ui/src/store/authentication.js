import axios from 'axios'

const state = {
    authenticated: false
}

const getters = {}

const actions = {
    authenticate({commit}, payload) {
        return axios
            .get('user', {
                auth: {
                    username: payload.username,
                    password: payload.password
                }
            })
            .then(r => commit('SET_AUTHENTICATED', !!r.data.name))
            .catch(() => commit('SET_AUTHENTICATED', false));
    },

    logout({commit}) {
        return axios
            .post('logout', {})
            .finally(() => commit('SET_AUTHENTICATED', false));
    }
}

const mutations = {
    SET_AUTHENTICATED(state, value) {
        state.authenticated = value;
    }
}

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}