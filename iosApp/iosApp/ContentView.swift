import SwiftUI
import shared

struct ContentView: View {
	var body: some View {
        AboutScreen()
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        Group {
            ContentView()
                .preferredColorScheme(.dark)
            ContentView()
                .preferredColorScheme(.light)
        }
	}
}