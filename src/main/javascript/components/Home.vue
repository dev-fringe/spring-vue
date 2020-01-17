<template>
    <div class="home">
        <v-btn color="info" @click="buttonClick()">Hello World</v-btn>
    </div>
</template>

<script>
export default {
	name: 'home',
	methods: {
		buttonClick() {
			alert('Hello World11!');
		}
	}
};
</script>