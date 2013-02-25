form "My Form" {

	"Bent u in het bezit van een woning?" hasHouse : bool
	if (hasHouse) {
		"Wat is de waarde van de woning? (hele euro's)" houseValue : int
		if (houseValue > 100000) {
			"Rookt u Marlboro?" marlboroSmoker : bool
			if (marlboroSmoker) {
				"Waarom?" marlboroReason : string
			}
		}
	}
	
	"Bent u samenwonend?" isLivingTogether : bool
	if (isLivingTogether) {
		"Wat is de naam van uw partner?" partnerName : string 
		"Wat is het BSN van uw partner?" partnerBsn : int
		"Wat is het verzamelinkomen van u en uw partner?" collectiveIncome : money
	} else { 
		"Wat is uw jaarlijkse inkomen?" personalIncome : money
	}
	
	if ((!isLivingTogether && personalIncome > 10000) || (isLivingTogether && collectiveIncome > 10000)) {
		"Bent u in het bezit van een Audi?" hasAudi : bool
		"Welk model?" audiModel : string
	}
}
