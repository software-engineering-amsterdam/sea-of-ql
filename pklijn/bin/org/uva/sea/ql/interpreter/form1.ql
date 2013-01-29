form form1 {
	age: "What is your age?" int
	isGirl: "Are you a girl?" boolean
	if (age >= 18 && isGirl) {
		whatItIsAllAbout: "Are you single?" boolean
		if (whatItIsAllAbout) {
			name: "What is your name?" string
		}
	}
	else {
		lifeIsHard: "Go away" boolean(true)
	}
}