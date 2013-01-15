form calculatedField {
  fieldset personal "Personal details" {
    "What is your age?"
      integer number
    "Your age times three equals:"
      integer numberx3 = number * 3
  }
  fieldset other "Other things" {
    "Other question"
      list["A", "B", "C"] enumQuestion
      .styleClass
  }
}
