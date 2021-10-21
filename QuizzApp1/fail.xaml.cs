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
    public partial class fail : ContentPage
    {
        public fail()
        {
            InitializeComponent();
        }

        private async void Button_Clicked_1(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new Login());
        }
    }
}