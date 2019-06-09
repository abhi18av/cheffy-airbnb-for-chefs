(ns app.core
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [app.db]
            [app.theme :refer [cheffy-theme]]
            ["@smooth-ui/core-sc" :refer [Normalize ThemeProvider Button]]))

(defn app
  []
  [:<>
   [:> Normalize]
   [:> ThemeProvider {:theme cheffy-theme}
    [:> Button "Hello, ClojureScript!"]]])

(defn ^:dev/after-load start
  []
  (rf/dispatch-sync [:initialize-db])
  (r/render [app]
            (.getElementById js/document "app")))

(defn ^:export init
  []
  (start))