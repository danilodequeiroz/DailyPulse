import SwiftUI
import shared

struct ContentView: View {

    var body : some View{
        ComposeView().ignoreSafeArea(.keyboard)
    }
}
struct ComposeView: UiViewControllerRepresentable{
    func makeUIViewController(context : Context)-> some UIViewController {
        MainIOSKit.MainViewController()
    }

      func updateUIViewController(_ iuViewController: UIViewControllerType, context: Context) {}
}