(function() {
    function valueToString(value) {
        return value != undefined ? value.toString() : undefined;
    }

    ko.bindingHandlers.booleanValue = {
        init:   function(element, valueAccessor, allBindingsAccessor) {
            var value = valueAccessor();
            var newValueAccessor = function() {
                return ko.computed({
                    read  : function() {
                        return valueToString(value());
                    },
                    write : function(newValue) {
                        value(newValue == "true");
                    }
                });
            }
            ko.bindingHandlers.checked.init(element, newValueAccessor, allBindingsAccessor);
        },
        update: function(element, valueAccessor) {
            var value = ko.utils.unwrapObservable(valueAccessor());
            var newValueAccessor = function() { return valueToString(value); }
            ko.bindingHandlers.checked.update(element, newValueAccessor);
        }
    };
})();