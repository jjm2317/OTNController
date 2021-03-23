

(function ($) {
    "use strict";


    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');
    var $token = $('.token');
    var $modal = $('.modal-window');
    var $modalHeading = $('.modal-heading');
    var $modalContent = $('.modal-content');


    $('.validate-form').on('submit',function(e){
        e.preventDefault();
        var check = true;

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }
        if ( check == true) {
            fetch("http://localhost:8888/authenticate", {
              method: "POST",
              headers: {
                "Content-Type": "application/json",
              },
              body: JSON.stringify({
                email: $(input[0]).val(),
                password: $(input[1]).val(),
              }),
            })
              .then((response) => response.json())
              .then((data) => {
                  var token = data.token;
                  $modal.html(`<div>
                      <a href="#" title="Close" onclick="$('.modal-window').toggleClass('active')" class="modal-close">Close</a>
                      <h1 class="modal-heading">${token === undefined ? "Login Fail" : "Your Token is"}</h1>
                      <div class="modal-content">
                        ${token === undefined ? "아이디 패스워드를 확인해주세요" : token}
                      </div>`)

                  $modal.toggleClass("active")

              })
        }

        return check;
    });


    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }



})(jQuery);