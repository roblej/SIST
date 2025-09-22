import { create } from "zustand";

const tokenStore = create((set) => ({
    accessToken: null,
    setToken(token){
        set({accessToken: token});
    },

}));
export default tokenStore;