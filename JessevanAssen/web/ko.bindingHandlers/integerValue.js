(function() {
    function valueToString(value) {
        return value != undefined ? value.toString() : undefined;
    }

    function isUndefinedOrEmpty(value) {
        return value == undefined || value == "";
    }

    function isValidInteger(value) {
        return /^-?[0-9]+$/.test(value);
    }

    ko.bindingHandlers.integerValue = {
        init:   function(element, valueAccessor, allBindingsAccessor) {
            var value = valueAccessor();
            var newValueAccessor = function() {
                return ko.computed({
                    read  : function() { return valueToString(value()); },
                    write : function(newValue) {
                        if(isUndefinedOrEmpty(newValue))
                            value(undefined);
                        if(isValidInteger(newValue))
                            value(parseInt(newValue, 10));
                        else
                            value(undefined);
                    }
                });
            }
            ko.bindingHandlers.value.init(element, newValueAccessor, allBindingsAccessor);
        },
        update: function(element, valueAccessor) {
            var value = ko.utils.unwrapObservable(valueAccessor());
            var newValueAccessor = function() { return valueToString(value); }
            ko.bindingHandlers.value.update(element, newValueAccessor);
        }
    };
})();