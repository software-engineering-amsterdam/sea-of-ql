module load::Load

import Prelude;
import syntax::Concrete; 
import syntax::Abstract;
import ParseTree;

public Form load(str txt) = implode(#Form, parse(#start[Form], txt));

/*
load("form Bocx1{hasSoldHouse:\"did you sell a house in 2010\"boolean hasBoughtHouse:\"did you buy ahouse in 2010?\"boolean hasMainLoan:\"did you enter a loan?\" boolean sellingPrice: \"price the house was sold:\"money privateDebt: \"Private debt for the sold house:\"money if(hasSoldHouse){valueResidue: \"Value residue:\"money(sellingPrice-privateDebt)}}");
checkForm("form Bocx1{hasSoldHouse:\"did you sell a house in 2010\"boolean hasBoughtHouse:\"did you buy ahouse in 2010?\"boolean hasMainLoan:\"did you enter a loan?\" boolean sellingPrice: \"price the house was sold:\"money privateDebt: \"Private debt for the sold house:\"money if(hasSoldHouse){valueResidue: \"Value residue:\"money(sellingPrice-privateDebt)}}");
generateQLForm("form Form1{hasSoldHouse:\"did you sell a house in 2010\"boolean hasBoughtHouse:\"did you buy ahouse in 2010?\"boolean hasMainLoan:\"did you enter a loan?\" boolean sellingPrice: \"price the house was sold:\"money privateDebt: \"Private debt for the sold house:\"money if(hasSoldHouse){valueResidue: \"Value residue:\"money(sellingPrice-privateDebt)}}");
*/