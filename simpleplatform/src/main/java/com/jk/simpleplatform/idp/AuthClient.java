package com.jk.simpleplatform.idp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.jk.simpleplatform.SimpleAuthResultCallback;

public abstract class AuthClient {

    public static AuthClient getAuthClientInstance(IdpType idpType){
        switch (idpType){
            case GOOGLE :
                return new GoogleAuthClient();
            case FACEBOOK :
                return new FacebookAuthClient();
        }

        return null;
    }

    public abstract void login(@NonNull Activity activity, @NonNull final SimpleAuthResultCallback<Void> callback);

    public abstract String getToken();

    public abstract String getEmail();

    public abstract IdpType getIdpType();

    public abstract boolean isSignedIn(@NonNull Activity activity);

    public abstract void onActivityResult(int requestCode, int resultCode, Intent data);

}
