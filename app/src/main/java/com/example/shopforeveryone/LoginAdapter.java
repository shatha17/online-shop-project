package com.example.shopforeveryone;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class LoginAdapter extends FragmentPagerAdapter {
    private Context context;
    int totalTab;
    private String[] tabTitles = new String[]{"Login", "Sign-up"};
    private String[] tabTitles2 = new String[]{"Woman", "Man","Kids", "All"};

    public LoginAdapter(@NonNull FragmentManager fm, Context context, int totalTab) {
        super(fm);
        this.context = context;
        this.totalTab = totalTab;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(totalTab==2)
            return tabTitles[position];
        else
            return tabTitles2[position];
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(totalTab==2) {
            switch (position) {
                case 0:
                    LoginTabFragment loginTabFragment = new LoginTabFragment();
                    return loginTabFragment;
                case 1:
                    SignupTabFragment signupTabFragment = new SignupTabFragment();
                    return signupTabFragment;
                default:
                    return null;
            }
        }
        else{
            switch (position) {
                case 0:
                    WomanTabFragment womanTabFragment=new WomanTabFragment();
                    return womanTabFragment;
                case 1:
                    MenTabFragment menTabFragment=new MenTabFragment();
                    return menTabFragment;
                case 2:
                    KidsTabFragment kidsTabFragment=new KidsTabFragment();
                    return kidsTabFragment;
                case 3:
                    AllTabFragment allTabFragment=new AllTabFragment();
                    return allTabFragment;
                default:
                    return null;
            }
        }
    }

    @Override
    public int getCount() {
        return totalTab;
    }
}
