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
    public partial class winnner : ContentPage
    {
        public winnner()
        {
            InitializeComponent();
        }
        private void Button_Clicked_1(object sender, EventArgs e)
        {
            this.Navigation.PushAsync(new Login());
        }
    }
}