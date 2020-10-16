<template>
  <v-container>
    <div class="text-h6">text-{breakpoint}-{value}로 반응형 제어</div>
    <div class="text-h1">h1</div>
    <div class="text-h2">h2</div>
    <div class="text-h3">h3</div>
    <div class="text-h4">h4</div>
    <div class="text-h5">h5</div>
    <div class="text-h6">h6</div>
    <div class="text-subtitle-1">subtitle-1</div>
    <div class="text-subtitle-2">subtitle-2</div>
    <div class="text-body-1">body-1</div>
    <div class="text-body-2">body-2</div>
    <div class="text-button">button</div>
    <div class="text-caption">caption</div>
    <div class="text-overline">overline</div>

    <div>
      <p class="font-weight-black">Black text.</p>
      <p class="font-weight-bold">Bold text.</p>
      <p class="font-weight-medium">Medium weight text.</p>
      <p class="font-weight-regular">Normal weight text.</p>
      <p class="font-weight-light">Light weight text.</p>
      <p class="font-weight-thin">Thin weight text.</p>
      <p class="font-italic">Italic text.</p>
    </div>

    <v-btn color="primary">primary</v-btn>
    <v-btn color="accent">accent</v-btn>
    <v-btn color="tertiary">tertiary</v-btn>
    <v-btn color="secondary">secondary</v-btn>
  </v-container>
</template>

<script>
export default {
  name: "Test",
};
</script>
