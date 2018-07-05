package neverest.ke.co.digiland

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import neverest.ke.co.digiland.fragments.auth.LoginFragment
import neverest.ke.co.digiland.fragments.auth.SplashFragment
import neverest.ke.co.digiland.utils.CoreUtils

class LoginActivity : AppCompatActivity() ,SplashFragment.SplashInterface,LoginFragment.LoginInterface{

    override fun changePage(p: Int) = switchPage(p)

    private var _page=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        switchPage(_page)

        if (CoreUtils.hasAuthorization()){
            val i= Intent(applicationContext,MainActivity::class.java)
            i.flags=Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(i)
        }else{
            switchPage(_page)
        }

    }
    fun switchPage(page:Int) {
        val ft = supportFragmentManager.beginTransaction()
//        ft.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);

        _page = page
        when (page) {
            1 -> {
                ft.replace(R.id.main_frame, SplashFragment(), "landing");ft.commit()
                Handler().postDelayed(Runnable {
                    switchPage(2)
                }, 3000)
            }
            2->{
                ft.replace(R.id.main_frame, LoginFragment(), "login");ft.commit()
            }
        }
    }
}
