package com.example.zooapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {

    var listOfAnamils = ArrayList<Animal>()
    var adapter:AnimalsAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listOfAnamils.add(
            Animal("Baboon","Baboon live in big place with tree",R.drawable.baboon,false))
        listOfAnamils.add(
            Animal("Bulldog","Bulldog live in big place with tree",R.drawable.bulldog,false))
        listOfAnamils.add(
            Animal("Panda","Panda live in big place with tree",R.drawable.panda,true))
        listOfAnamils.add(
            Animal("Bird","Bird live in big place with tree",R.drawable.swallow_bird, false))
        listOfAnamils.add(
            Animal("Tiger","Tiger live in big place with tree",R.drawable.white_tiger,true))
        listOfAnamils.add(
            Animal("Zebra","Zebra live in big place with tree",R.drawable.zebra,false))

        adapter = AnimalsAdapter(this,listOfAnamils)
        tvListAnimal.adapter = adapter
    }


    class AnimalsAdapter(context: Context, var listOfAnimals: ArrayList<Animal>) : BaseAdapter() {
        var context:Context?= context
        override fun getCount(): Int {
           return  listOfAnimals.size
        }

        override fun getItem(p0: Int): Any {
            return listOfAnimals[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val animal = listOfAnimals[p0]
            if (animal.isKiller ==true){
                var inflator =
                    context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflator.inflate(R.layout.animal_killer_ticket, null)
                myView.tvName.text = animal.name!!
                myView.tvDes.text = animal.des!!
                myView.ivAnimalImage.setImageResource(animal.image!!)
                myView.ivAnimalImage.setOnClickListener{
                    val intent = Intent(context, AnimalInfo::class.java)
                    intent.putExtra("name", animal.name!!)
                    intent.putExtra("des",animal.des!!)
                    intent.putExtra("image",animal.image!!)
                    context!!.startActivity(intent)
                }
                return myView
            }else {
                var inflator =
                    context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflator.inflate(R.layout.animal_ticket, null)
                myView.tvName.text = animal.name!!
                myView.tvDes.text = animal.des!!
                myView.ivAnimalImage.setImageResource(animal.image!!)
                myView.ivAnimalImage.setOnClickListener{
                    val intent = Intent(context, AnimalInfo::class.java)
                    intent.putExtra("name", animal.name!!)
                    intent.putExtra("des",animal.des!!)
                    intent.putExtra("image",animal.image!!)
                    context!!.startActivity(intent)
                }
                return myView
            }
        }

    }
}