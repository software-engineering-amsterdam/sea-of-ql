form calculatedField {
  "Number?", integer, number
  /* Now for some weird stuff: The line below works (see Forms.rsc -> main()) */
  "Working:", integer, numberx3: boolean
  /* And this one is broken. */
  "Broken:", integer, numberx3: number * 3
}
