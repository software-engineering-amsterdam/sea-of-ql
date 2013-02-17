function getValueOf(id) {
    $elm = $('#'+id);
    if ($elm.is('input')) {
        if ($elm.is('input:checkbox')) {
            if ($elm.is(':checked')) {
                return true;
            } else {
                return false;
            }
        } else {
            return $elm.val();
        }
    } else {
        // unsupported type;
        return false;
    }
}

function Observer() {
    this.fns = [];
}

Observer.prototype = {
    subscribe : function(fn) {
        this.fns.push(fn);
    },
    unsubscribe : function(fn) {
        this.fns = this.fns.filter(
            function(el) {
                if ( el !== fn ) {
                    return el;
                }
            }
        );
    },
    fire : function(o, thisObj) {
        var scope = thisObj || window;
        this.fns.forEach(
            function(el) {
                el.call(scope, o);
            }
        );
    }
};
