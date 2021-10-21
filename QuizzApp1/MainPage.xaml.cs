using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace QuizzApp
{
    public partial class MainPage : ContentPage
    {
        public MainPage()
        {
            InitializeComponent();
        }

        private async void Button_Clicked(object sender, EventArgs e)
        {
            await DisplayAlert("Mensaje", "Respuesta Correcta", "Ok");
            await Navigation.PushAsync(new winnner());
        }

        private async void btnIncorrecto_Clicked(object sender, EventArgs e)
        {
            await DisplayAlert("Mensaje", "Respuesta Incorrecta", "Ok");
            await Navigation.PushAsync(new fail());
        }
    }
}
