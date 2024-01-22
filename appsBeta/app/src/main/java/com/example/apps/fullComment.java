package com.example.apps;

public class fullComment {

    /*        Username = (EditText) findViewById(R.id.signUpUsername);
        Email = (EditText) findViewById(R.id.signUpEmail);
        Password = (EditText) findViewById(R.id.signUpPassword);
        ConfirmPassword = (EditText) findViewById(R.id.confirmPassword);
        SignUp = (Button) findViewById(R.id.SignupBtn);
        LoginRedirect = (Button) findViewById(R.id.loginRedirect);
        DB = new DBaseHelper(this);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = Username.getText().toString();
                String email = Email.getText().toString();
                String password = Password.getText().toString();
                String password2 = ConfirmPassword.getText().toString();

                if (user.equals("") || email.equals("") || password.equals("") || password2.equals("")){
                    Toast.makeText(Signup.this, "fields cannot blank", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (password.equals(password2)){
                        Boolean checkUser = DB.CheckUsername(user);
                        if (checkUser==false){
                            Boolean insert = DB.insert(user, password, email);
                            if (insert==true){
                                Toast.makeText(Signup.this, "Sign Up Succesfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Login.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(Signup.this, "Sign Up Failed", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(Signup.this, "User already exists", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Signup.this, "Password didn't match", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        LoginRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);

            }
        });*/

    /*DB = new DBaseHelper(this);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals("")){
                    Toast.makeText(Login.this, "All fields must be filled", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean checkUserPass = DB.CheckUsernamePassword(user, pass);
                    if (checkUserPass==true){
                        Toast.makeText(Login.this, "Welcome!!!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(Login.this, "Account Doesn't exists", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        SignUpRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Signup.class);
                startActivity(intent);

            }
        });*/

}
