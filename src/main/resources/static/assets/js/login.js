

(function ($) {
    "use strict";


    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');
    var $modal = $('.modal-window');


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
              .then((data) => data.token)
              .then(token => {

                  $modal.html(`<div>
                      <a href="#" title="Close" onclick="$('.modal-window').toggleClass('active')" class="modal-close">Close</a>
                      <h1 class="modal-heading">${token === undefined ? "Login Fail" : "Your Token is"}</h1>
                      ${token === undefined ? "" : '<button class="modal-copy">copy</button>'}`+
                      (token === undefined? `<div class="modal-content">아이디 패스워드를 확인해주세요</div>`: `<input type=text" class="modal-content"
                        value=${token}>
                      `));
                  $('.modal-content').val('Bearer ' + $('.modal-content').val());

                  $modal.toggleClass("active")
                  $('.modal-copy').on('click', e => {
                      e.preventDefault();
                      $('.modal-content').select();

                      document.execCommand('copy');
                  });


              })
        }

        return check;
    });

    $('.move-swagger').on('click', e => {
        location.href="/swagger-ui.html";
    })
    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim() == '') {
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