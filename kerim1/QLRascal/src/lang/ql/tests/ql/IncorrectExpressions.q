form IncorretExpressions {
	incorrectBool: "Should be a boolean" bool(2 - 1)
	incorrectInt: "Should be an integer" int(1 < 2)
	incorrectString: "Should be a string" string(true)
	
   	shouldBeBool: "Should be bool, is int" int
	
   	if (shouldBeBool) {
   		noncomputed1: "Non computed 1" int
   	}
   	else if (+"abc") {
   		noncomputed2: "Non computed 2" int
   	}
   	else if (-true) {
   		noncomputed3: "Non computed 3" int
   	}
   	else if (!123) {
   		noncomputed4: "Non computed 4" int
   	}
   	else if (false < true) {
   		noncomputed5: "Non computed 5" int
   	}
   	else if (1 <= "abc") {
   		noncomputed6: "Non computed 6" int
   	}
   	else if (false && (12 == "abc")) {
   		noncomputed7: "Non computed 7" int
   	}
   	else if (anUndefinedVariable) {
   		noncomputed8: "Non computed 8" int
   	}
   	
   	if (x) {
   		y: "This is y!" bool
   		if (z) {
   			z: "This is z!" bool
   		}
   	}
   	if (y) {
   		x: "This is x!" bool
   	}
}