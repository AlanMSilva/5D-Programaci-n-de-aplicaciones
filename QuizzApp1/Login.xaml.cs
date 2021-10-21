using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace QuizzApp
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class Login : ContentPage
    {
        public Login()
        {
            InitializeComponent();
        }
        private async void Button_Clicked(object sender, EventArgs e)
        {
            string sUsuario = usuario.Text;

            if (sUsuario == null)
            {
                await DisplayAlert("Mensaje", "Ingresa tu Usuario", "Ok");
            }
            else
            {
                await Navigation.PushAsync(new MainPage());
            }
        }
    }
}