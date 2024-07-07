import shared
import SwiftUI

struct ContentView: View {
    var body: some View {
        ComposeView().ignoresSafeArea(.keyboard)
    }
}

struct ComposeView: UIViewControllerRepresentable {
    typealias UIViewControllerType = UIViewController

    func makeUIViewController(context _: Context) -> UIViewController {
        MainIOSKt.MainViewContoller()
    }

    func updateUIViewController(_: UIViewControllerType, context _: Context) {}
}
