form complexForm {
	"Question one" boolean abool
	if(abool && true) {
		"Should be simplified to if(abool)" boolean abool2
	} else {
		"This went wrong" boolean abool3
	}
	if(! (true && true)) {
		"Should eval to false" boolean abool4
	}
	if(! (true || false) || !(true && false)) {
		"Should eval to false" boolean abool5
	}
}
